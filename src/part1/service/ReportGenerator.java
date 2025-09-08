package part1.service;

import part1.model.BaseFile;

public interface ReportGenerator<T extends BaseFile> {
    String generate(T file);
}
