package com.coderoom.ares.adapter.drone.flight.commands

import com.coderoom.ares.adapter.drone.flight.FlightCommand
import com.coderoom.ares.adapter.drone.flight.TelloDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class FlightCommandForward(
    private val telloDriver: TelloDriver,
    private val delayInMillis: Long
) : FlightCommand {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    override fun execute() {
        Thread.sleep(delayInMillis)
    }
}