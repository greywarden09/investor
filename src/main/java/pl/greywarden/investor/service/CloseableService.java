package pl.greywarden.investor.service;

import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.io.Closeable;
import java.io.IOException;

@Service
public class CloseableService {

    public void closeCloseable(@Nullable Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
    }
}
