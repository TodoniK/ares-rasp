package com.coderoom.ares.adapter.drone.flight.commands

import com.coderoom.ares.adapter.drone.flight.FlightCommand
import com.coderoom.ares.adapter.drone.flight.TelloDriver

class FlightCommandStop(

    private val telloDriver: TelloDriver,

) : FlightCommand {
    override fun execute() {

    }
}