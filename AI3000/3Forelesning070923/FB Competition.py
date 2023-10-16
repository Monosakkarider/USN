import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score

# Load the data
data = pd.read_csv('FB competition.csv')

# Preprocess the data
time_value = pd.to_datetime(data["time"], unit="s")
data["day"] = time_value.dt.day
data["weekday"] = time_value.dt.weekday
data["hour"] = time_value.dt.hour

X = data[["x", "y", "accuracy", "day", "weekday", "hour"]]
y = data['place_id']

# Split the data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Standardize the features
scaler = StandardScaler()
X_train_scaled = scaler.fit_transform(X_train)
X_test_scaled = scaler.transform(X_test)

# Train and predict using k-Nearest Neighbors
k = 3
knn = KNeighborsClassifier(n_neighbors=k)
knn.fit(X_train_scaled, y_train)

y_pred = knn.predict(X_test_scaled)

print("Predicted labels:")
print(y_pred)
accuracy = accuracy_score(y_test, y_pred)
print("Accuracy:", accuracy)
