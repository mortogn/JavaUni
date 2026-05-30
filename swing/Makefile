JAVAC = javac
JAVA = java
SRC = Main.java
CLASS = Main

.PHONY : clean compile run

clean:
	find . -name "*.class" -type f -delete

compile: $(SRC)
	$(JAVAC) -cp ".:lib/*" $(SRC)

run: clean compile
	$(JAVA) -cp ".:lib/*" $(CLASS)

run-no-clean: compile
	$(JAVA) -cp ".:lib/*" $(CLASS)