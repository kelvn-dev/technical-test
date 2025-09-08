package service;

import model.BaseFile;

public interface FileAnalyzer<T extends BaseFile> {
    T analyze(T file);
}
