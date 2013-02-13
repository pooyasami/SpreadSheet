JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        SpreadSheet.java

default: classes
	@echo To run the compiled application from terminal try 'java SpreadSheet inputFileName.csv > outputFileName.out'

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
