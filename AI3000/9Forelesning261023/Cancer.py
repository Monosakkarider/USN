import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import confusion_matrix, recall_score

# Load the dataset
column_names = ['Sample code number', 'Clump Thickness', 'Uniformity of Cell Size', 'Uniformity of Cell Shape',
                'Marginal Adhesion', 'Single Epithelial Cell Size', 'Bare Nuclei', 'Bland Chromatin',
                'Normal Nucleoli', 'Mitoses', 'Class']

data = pd.read_csv("breast-cancer-wisconsin.data", names=column_names)

# Data processing
data.replace("?", np.nan, inplace=True)
data.dropna(inplace=True)

# Map class labels to binary values (2 -> 0 for benign, 4 -> 1 for malignant)
data['Class'] = data['Class'].map({2: 0, 4: 1})

# Split data into features (X) and target (y)
X = data.drop('Class', axis=1)
y = data['Class']

# Split data into train and test sets (80% train, 20% test)
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Standardize the data using StandardScaler
scaler = StandardScaler()
X_train_scaled = scaler.fit_transform(X_train)
X_test_scaled = scaler.transform(X_test)

# Create and train a logistic regression model
logreg_model = LogisticRegression()
logreg_model.fit(X_train_scaled, y_train)

# Make predictions on the test set
y_pred = logreg_model.predict(X_test_scaled)

# Calculate the confusion matrix
confusion = confusion_matrix(y_test, y_pred)

# Create a custom confusion matrix with rows rearranged
custom_confusion = np.array([[confusion[1, 1], confusion[1, 0]], [confusion[0, 1], confusion[0, 0]]])

# Calculate the recall for the malignant class
recall_malignant = recall_score(y_test, y_pred)

# Print the custom confusion matrix
print("Confusion Matrix:")
print(custom_confusion)

# Print the recall for the malignant class
print("\nRecall (True Positive Rate) for Malignant Class: {:.2f}".format(recall_malignant))

# Plot the confusion matrix
plt.figure(figsize=(8, 6))
plt.imshow(custom_confusion, cmap='Blues', interpolation='nearest')
plt.colorbar()
tick_marks = np.arange(2)
plt.xticks(tick_marks, ['Malignant', 'Benign'], rotation=45)
plt.yticks(tick_marks, ['Malignant', 'Benign'])
plt.xlabel('Predicted')
plt.ylabel('True')
for i in range(2):
    for j in range(2):
        plt.text(j, i, str(custom_confusion[i, j]), ha='center', va='center', color='black', fontsize=14)
plt.title('Confusion Matrix')
plt.show()


