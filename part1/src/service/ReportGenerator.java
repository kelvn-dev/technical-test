package service;

import model.BaseFile;

public interface ReportGenerator<T extends BaseFile> {
    String generate(T file);
}
