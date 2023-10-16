import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.naive_bayes import MultinomialNB
from sklearn.metrics import accuracy_score, classification_report
from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords
from nltk.stem import PorterStemmer
import nltk
nltk.download('punkt')
nltk.download('stopwords')

# Load the CSV file
data = pd.read_csv('spam.csv')

# Define a function for text preprocessing
def preprocess_text(text):
    # Tokenize the text
    tokens = word_tokenize(text)
    
    # Remove stopwords
    stop_words = set(stopwords.words('english'))
    filtered_tokens = [word for word in tokens if word.lower() not in stop_words]
    
    # Stemming using Porter Stemmer
    stemmer = PorterStemmer()
    stemmed_tokens = [stemmer.stem(word) for word in filtered_tokens]
    
    return ' '.join(stemmed_tokens)

# Apply text preprocessing to the "Message" column
data['Message'] = data['Message'].apply(preprocess_text)

# Convert text data to numerical data using TF-IDF
tfidf_vectorizer = TfidfVectorizer()
X = tfidf_vectorizer.fit_transform(data['Message'])
y = data['Category']

# Split the dataset into training and testing sets (80% train, 20% test)
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Initialize and train the Naive Bayes classifier
naive_bayes_classifier = MultinomialNB()
naive_bayes_classifier.fit(X_train, y_train)

# Make predictions on the test set
y_pred = naive_bayes_classifier.predict(X_test)

# Evaluate the classifier
accuracy = accuracy_score(y_test, y_pred)
classification_rep = classification_report(y_test, y_pred)

print(f'Accuracy: {accuracy}')
print(classification_rep)

# Function to classify a new review
def classify_new_review(new_review):
    preprocessed_review = preprocess_text(new_review)
    preprocessed_review_vectorized = tfidf_vectorizer.transform([preprocessed_review])
    category = naive_bayes_classifier.predict(preprocessed_review_vectorized)[0]
    return category

# Example usage:
new_review = "This is a new review, not spam."
category = classify_new_review(new_review)
print(f"The category of the new review is: {category}")
