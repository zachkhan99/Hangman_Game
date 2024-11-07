# Define the Java files and the main class
JAVAC = javac
JAVA = java
MAIN_CLASS = Main
SRC = Main.java Hangman.java
CLASS_FILES = $(SRC:.java=.class)

# Default target - compile and run the program
all: $(MAIN_CLASS)
	$(JAVA) $(MAIN_CLASS)

# Compile the Java files
$(MAIN_CLASS): $(CLASS_FILES)

$(CLASS_FILES): %.class: %.java
	$(JAVAC) $<

# Clean up .class files
clean:
	rm -f $(CLASS_FILES)

# Optionally, add a target for just compiling the program
compile:
	$(JAVAC) $(SRC)

