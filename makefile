# Makefile for Binary Search Tree


LIB = ../lib
SRCDIR = src
BINDIR = bin
TESTDIR = test
DOCDIR = doc

CLI = $(LIB)/cli/commons-cli-1.3.1.jar
ASM = $(LIB)/asm/asm-5.0.4.jar:$(LIB)/asm/asm-commons-5.0.4.jar:$(LIB)/asm/asm-tree-5.0.4.jar
#JUNIT = $(LIB)/junit/junit-4.12.jar:$(LIB)/junit/hamcrest-core-1.3.jar
JACOCO = $(LIB)/jacoco/org.jacoco.core-0.7.5.201505241946.jar:$(LIB)/jacoco/org.jacoco.report-0.7.5.201505241946.jar:
#TOOLS = $(LIB)/tools

JAVAC = javac
JFLAGS = -g -d $(BINDIR) -cp $(BINDIR)

vpath %.java $(SRCDIR)/:$(TESTDIR)
vpath %.class $(BINDIR)/:$(BINDIR)/test

# define general build rule for java sources
.SUFFIXES:  .java  .class

.java.class:
	$(JAVAC)  $(JFLAGS)  $<

#default rule - will be invoked by make
all:	 BinaryTreeNode.class BTQueueNode.class BTQueue.class BinaryTree.class\
	     BinarySearchTree.class DamBSTApp.class AVLTree.class DamAVLApp.class


# Rules for generating documentation
doc:
	javadoc -d $(DOCDIR) -link http://docs.oracle.com/javase/8/docs/api/ $(SRCDIR)/*.java

# Rules for unit testing
# Add additional Testxx.class file to this line and to TestSuite.java
test_classes: all TestBinarySearchTree.class TestSuite.class

test: test_classes
	java -ea -cp $(BINDIR):$(JUNIT) org.junit.runner.JUnitCore TestSuite

# Rules for generating tests
jacoco.exec: test_classes
	java -ea -javaagent:$(LIB)/jacoco/jacocoagent.jar -cp $(BINDIR):$(JUNIT) org.junit.runner.JUnitCore TestSuite

report: jacoco.exec
	java -cp $(BINDIR):$(CLI):$(JACOCO):$(ASM):$(TOOLS) Report --reporttype html .

clean:
	@rm -f  $(BINDIR)/*.class
	@rm -f $(BINDIR)/*/*.class
	@rm -Rf coverage reporttype
	@rm -Rf doc
	#rm *.class
