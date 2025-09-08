package part1.service;

import part1.model.BaseFile;

public interface FileParser<T extends BaseFile> {
    T parse(String url);
}
