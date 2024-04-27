package com.example.sita.task2.service;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FilePathService {
	
	private static final Logger logger = LoggerFactory.getLogger(FilePathService.class);

	private Path processedDirectory = Paths.get("C:\\SITA_TEST_TASK\\PROCESSED");
	private Path errorDirectory = Paths.get("C:\\SITA_TEST_TASK\\ERROR");
	
	private Path inDirectory = Paths.get("C:\\SITA_TEST_TASK\\IN");
	private Path outDirectory = Paths.get("C:\\SITA_TEST_TASK\\OUT");
	

	@Scheduled(cron = "*/5 * * * * *")
	public void FilesProcess() {

		logger.info("Starting processing.");
		try {
			int total = 0;
			List<Path> List = Files.list(inDirectory).collect(Collectors.toList());
			for (Path file : List) {
				try {
					List<String> lineList = Files.readAllLines(file);
					total = lineList.stream().filter(line -> !line.trim().isBlank()).mapToInt(Integer::parseInt).sum();
					
					String opFileName = file.getFileName().toString() + ".OUTPUT";
					Path outputFile = outDirectory.resolve(opFileName);
					
					Files.write(outputFile, String.valueOf(total).getBytes());
					Files.move(file, processedDirectory.resolve(file.getFileName() + ".PROCESSED"));
					
				} catch (NumberFormatException | IOException e) {
					
					Files.move(file, errorDirectory.resolve(file.getFileName() + ".ERROR"));
				}
			}
		} catch (Exception e) {
			logger.error("Exception occured due to {}", e.getMessage());
			e.printStackTrace();
		}
		logger.info("End of processing.");

	}

}
