package com.cole.asciiapp.repository;

import com.cole.asciiapp.model.Ascii;
import org.springframework.content.commons.repository.ContentStore;

public interface AsciiStore extends ContentStore<Ascii, String> {
}
