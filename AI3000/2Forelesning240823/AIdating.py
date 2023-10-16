import pandas as pd
from sklearn.preprocessing import StandardScaler

# Load the data from the "Scaling-dating.txt" file with tabs as the delimiter
file_name = "Scaling-dating.txt"
df = pd.read_csv(file_name, delimiter='\t')

# Select the first 3 columns as features (X)
X = df.iloc[:, :3]

# Select the last column as the target variable (y)
y = df.iloc[:, -1]

# Initialize the StandardScaler for normalization
scaler = StandardScaler()

# Fit and transform the feature matrix (X)
X_normalized = scaler.fit_transform(X)

# Create a DataFrame with the normalized features
X_normalized_df = pd.DataFrame(X_normalized, columns=X.columns)

# Print the original data
print("Original Data:")
print(df)

# Print the new data with normalized features
print("\nData with Normalized Features:")
print(X_normalized_df)
