package service;

import model.BaseFile;

public interface FileParser<T extends BaseFile> {
    T parse(String url);
}
