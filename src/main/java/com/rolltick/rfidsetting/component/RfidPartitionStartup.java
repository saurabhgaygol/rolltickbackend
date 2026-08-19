package com.rolltick.rfidsetting.component;

import org.springframework.stereotype.Component;

import com.rolltick.rfidsetting.service.RfidPartitionService;

import jakarta.annotation.PostConstruct;

@Component
public class RfidPartitionStartup {

    private final RfidPartitionService partitionService;

    public RfidPartitionStartup(RfidPartitionService partitionService) {
        this.partitionService = partitionService;
    }

    @PostConstruct
    public void init() {

        partitionService.createMissingPartitions();

    }
}