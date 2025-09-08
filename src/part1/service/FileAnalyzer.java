package part1.service;

import part1.model.BaseFile;

public interface FileAnalyzer<T extends BaseFile> {
    T analyze(T file);
}
