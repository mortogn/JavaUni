JAVAC = javac
JAVA = java
SRC = Main.java
CLASS = Main

.PHONY : clean compile run

clean:
	find . -name "*.class" -type f -delete

compile: $(SRC)
	$(JAVAC) $(SRC)

run: clean compile
	$(JAVA) $(CLASS)

run-no-clean: compile
	$(JAVA) $(CLASS)