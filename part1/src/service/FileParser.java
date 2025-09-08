package service;

import model.BaseFile;

import java.io.IOException;

public interface FileParser<T extends BaseFile> {
    T parse(String url) throws IOException;
}
