import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.ensemble import ExtraTreesClassifier

# Load the data from the "train.csv" file
file_name = "train.csv"
df = pd.read_csv(file_name)

# Replace missing values with the median
df_filled = df.fillna(df.median())

# Split the data into features (X) and target variable (y)
X = df_filled.iloc[:, :-1]  # Select all columns except the last one
y = df_filled.iloc[:, -1]   # Select the last column

# Initialize the ExtraTreesClassifier
model = ExtraTreesClassifier()

# Fit the model to the data
model.fit(X, y)

# Get feature importances
importances = model.feature_importances_

# Sort feature importances in descending order
indices = np.argsort(importances)[::-1]

# Select the top 5 important features
top_5_features = X.columns[indices][:5]
top_5_importances = importances[indices][:5]

# Visualize the feature importances
plt.figure(figsize=(10, 6))
plt.title("Top 5 Important Features")
plt.bar(range(5), top_5_importances, align="center")
plt.xticks(range(5), top_5_features, rotation=45)
plt.xlabel("Features")
plt.ylabel("Importance Score")
plt.tight_layout()
plt.show()

# Print the top 5 important features and their importance scores
print("Top 5 Important Features:")
for feature, importance in zip(top_5_features, top_5_importances):
    print(f"{feature}: {importance:.4f}")

