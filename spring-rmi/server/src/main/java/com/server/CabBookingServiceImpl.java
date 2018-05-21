package com.server;

import com.server.shared.CabBookingService;
import org.springframework.stereotype.Service;

@Service
public class CabBookingServiceImpl implements CabBookingService {

    @Override
    public int doSome(int a, int b) {
        return a + b;
    }
}
