import os

# Directory containing the Java files
directory = "D:/ASU/sem 9/SDP/PROJ/ITER1/src/School"

# Iterate over all Java files in the directory
for filename in os.listdir(directory):
    if filename.endswith(".java"):
        filepath = os.path.join(directory, filename)
        with open(filepath, "r+") as file:
            content = file.read()
            file.seek(0, 0)  # Move to the beginning of the file
            file.write("package School;\n\n" + content)
            print(filename)
    