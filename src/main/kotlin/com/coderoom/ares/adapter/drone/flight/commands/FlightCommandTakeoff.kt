package com.coderoom.ares.adapter.drone.flight.commands

import com.coderoom.ares.adapter.drone.flight.FlightCommand
import com.coderoom.ares.adapter.drone.flight.TelloDriver

class FlightCommandTakeoff(
    private val telloDriver: TelloDriver,
    private val delayInMillis: Long
) : FlightCommand {

    override fun execute() {

        if(telloDriver.isConnected)
        {
            telloDriver.takeOff()
        }
        Thread.sleep(delayInMillis)
    }
}