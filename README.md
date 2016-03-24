WordCountEngine
---------------
Web service to count the occurance of a word in the corpus source.
The word search is non case sensitive.
The corpus source can be a text file or folder which contains text files.
If folder contains other than text files it will be skipped.
	
Buil Steps
----------
1. Go to project directory
2. mvn clean install
3. cd target 
4. java -cp WordCountEngine-0.0.1-SNAPSHOT.jar com.freecharge.problem.wordcount.services.WordCountServiceInitiator corpus_source_path

Rest URI 
--------
GET Request to get the word count: http://<hostip>:8080/WordCountEngine?query=wordToSearch

GET Request to get the corpus source files list : http://<hostip>:8080/WordCountEngine/sourceFiles
