import os
import random
import numpy as np
from keras.models import Sequential
from keras.layers import Conv2D, MaxPooling2D
from keras.layers import Dense, Flatten
from keras.preprocessing import image
from keras.preprocessing.image import ImageDataGenerator
from sklearn.metrics import confusion_matrix
import seaborn as sns
import matplotlib.pyplot as plt

# Constants
TRAIN_DIR = 'C:\\Users\\Roman\\Desktop\\Train\\Train'
TRAIN_FRACTION = 0.8
RANDOM_SEED = 2018

# Function to split data into train and test sets
def make_train_and_test_sets():
    train_examples, test_examples = [], []
    shuffler = random.Random(RANDOM_SEED)

    for class_label, class_name in enumerate(['cat', 'dog']):
        class_path = os.path.join(TRAIN_DIR, class_name)
        if os.path.isdir(class_path):
            filenames = os.listdir(class_path)
            shuffler.shuffle(filenames)
            num_train = int(len(filenames) * TRAIN_FRACTION)
            full_filenames = [os.path.join(class_path, f) for f in filenames]
            examples = list(zip(full_filenames, [class_label] * len(filenames)))
            train_examples.extend(examples[:num_train])
            test_examples.extend(examples[num_train:])

    shuffler.shuffle(train_examples)
    shuffler.shuffle(test_examples)

    classes = {class_label: class_name for class_label, class_name in enumerate(['cat', 'dog'])}

    return train_examples, test_examples, classes

# Split the data into train and test sets and get the label classes
TRAIN_EXAMPLES, TEST_EXAMPLES, CLASSES = make_train_and_test_sets()
NUM_CLASSES = len(CLASSES)

print('\nThe dataset has %d label classes: %s' % (NUM_CLASSES, CLASSES.values()))
print('There are %d training images' % len(TRAIN_EXAMPLES))
print('There are %d test images' % len(TEST_EXAMPLES))

# Initializing the CNN
classifier = Sequential()

# Step 1 - Convolution
classifier.add(Conv2D(32, (3, 3), input_shape=(64, 64, 3), activation='relu'))

# Step 2 - Max Pooling
classifier.add(MaxPooling2D(pool_size=(2, 2)))

# Step 3 - Flattening
classifier.add(Flatten())

# Step 4 - Full Connection
classifier.add(Dense(units=128, activation='relu'))
classifier.add(Dense(units=1, activation='sigmoid'))

# Compiling the CNN
classifier.compile(optimizer='adam', loss='binary_crossentropy', metrics=['accuracy'])

# Data Augmentation
train_datagen = ImageDataGenerator(
    rescale=1./255,
    shear_range=0.2,
    zoom_range=0.2,
    horizontal_flip=True)

# Load your training and testing data using flow_from_directory
from keras.preprocessing.image import ImageDataGenerator
train_set = train_datagen.flow_from_directory(TRAIN_DIR, target_size=(64, 64), batch_size=32, class_mode='binary')

# Train the CNN
classifier.fit_generator(train_set, steps_per_epoch=len(train_set), epochs=1)

# Define the show_confusion_matrix function
def show_confusion_matrix(test_labels, predictions):
    """Compute confusion matrix and normalize."""
    confusion = sk_metrics.confusion_matrix(
        np.argmax(test_labels, axis=1), predictions)
    confusion_normalized = confusion.astype("float") / confusion.sum(axis=1)[:, np.newaxis]
    axis_labels = list(CLASSES.values())
    ax = sns.heatmap(
        confusion_normalized, xticklabels=axis_labels, yticklabels=axis_labels,
        cmap='Blues', annot=True, fmt='.2f', square=True)
    plt.title("Confusion matrix")
    plt.ylabel("True label")
    plt.xlabel("Predicted label")
plt.show()  

#To predict new images (you can try your image)
def predict_image(imagepath, classifier):
    predict = image.load_img(imagepath, target_size = (64, 64))   
    predict_modified = image.img_to_array(predict)
    predict_modified = predict_modified / 255
    predict_modified = np.expand_dims(predict_modified, axis = 0)
    result = classifier.predict(predict_modified)
    if result[0][0] >= 0.5:
        prediction = 'dog'
        probability = result[0][0]
        print ("probability = " + str(probability))
    else:
        prediction = 'cat'
        probability = 1 - result[0][0]
        print ("probability = " + str(probability))
        print("Prediction = " + prediction)
