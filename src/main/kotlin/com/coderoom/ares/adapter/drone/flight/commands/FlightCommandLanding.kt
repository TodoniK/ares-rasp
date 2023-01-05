package com.coderoom.ares.adapter.drone.flight.commands

import com.coderoom.ares.adapter.drone.flight.FlightCommand
import com.coderoom.ares.adapter.drone.flight.TelloDriver

class FlightCommandLanding(
    private val telloDriver: TelloDriver
) : FlightCommand {
    override fun execute() {

        if (telloDriver.isConnected) {
            with(telloDriver){
                streamOff()
                land() //Use emergency() to stop immediately instead of landing
                disconnect()
            }
        }
    }
}