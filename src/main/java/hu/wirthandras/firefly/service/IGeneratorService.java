package hu.wirthandras.firefly.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import hu.wirthandras.firefly.controller.Input;

@Service
public interface IGeneratorService {

	File generate() throws IOException;

	void addData(Input input);

}
