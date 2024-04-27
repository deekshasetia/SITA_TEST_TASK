By : Deeksha Setia

Created new maven project using - https://start.spring.io/;
Unzipped the downloaded zipped file

We've developed a service to process input files, sorting them into different directories based on their validity. 
Valid files contain only numerics, while invalid ones may contain alphabets, alphanumerics, or special characters.

We've implemented a processFiles method, scheduled to run every 5 seconds using a cron expression. 
This method sorts the files into appropriate directories:

Valid files are moved from the "IN" directory to the "OUT" directory. 
Their filenames are appended with ".OUTPUT" and include the sum of the numbers present in the file. 
Additionally, a copy of the valid file is stored in the "PROCESSED" directory, with ".PROCESSED" appended to the filename.
Invalid files are moved from the "IN" directory to the "ERROR" directory, with ".ERROR" appended to their filenames.
This setup ensures efficient and automated processing of input files,
maintaining organized directories for both valid and invalid files.