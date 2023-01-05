package com.coderoom.ares.adapter.drone

import com.coderoom.ares.adapter.drone.flight.FlightCommandProcessor
import com.coderoom.ares.adapter.drone.flight.TelloDriver
import com.coderoom.ares.adapter.drone.flight.commands.FlightCommandForward
import com.coderoom.ares.adapter.drone.flight.commands.FlightCommandLanding
import com.coderoom.ares.adapter.drone.flight.commands.FlightCommandStart
import com.coderoom.ares.adapter.drone.flight.commands.FlightCommandStop
import com.coderoom.ares.adapter.drone.flight.commands.FlightCommandTakeoff
import org.springframework.stereotype.Repository


@Repository
class DroneTelloRepository : DroneRepository {

    val tello = TelloDriver()
    override fun lanceVol(): Boolean {

        return if (TelloSemaphore.launched) {
            false
        } else {
            TelloSemaphore.launched = true
            FlightCommandProcessor()
                .addCommand(FlightCommandStart(tello))
                .addCommand(FlightCommandTakeoff(tello, 4000L))
                .addCommand(FlightCommandForward(tello, 4000L))
                .addCommand(FlightCommandLanding(tello))
                .addCommand(FlightCommandStop(tello))
                .asyncProcessCommand()
            true
        }
    }

    object TelloSemaphore {
        var launched = false
    }
}

