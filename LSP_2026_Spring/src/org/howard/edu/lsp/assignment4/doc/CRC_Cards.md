# CRC Cards – Air Traffic Control System

---

## Class: GroundStationReceiver

### Responsibilities
- Receive raw transponder packets from aircraft broadcasts.
- Capture incoming packet data from the transmission medium.
- Forward received packets to the `PacketParser` for processing.

### Collaborators
- PacketParser

---

## Class: ControllerInterface

### Responsibilities
- Accept queries from the flight controller (e.g., search aircraft by ID).
- Request specific aircraft details from the database.
- Present retrieved aircraft information to the controller.

### Collaborators
- AircraftDatabase
- Aircraft

---

## Class: PacketParser

### Responsibilities
- Receive raw transponder packets from the `GroundStationReceiver`.
- Extract flight data and aircraft identifiers from packet format.
- Translate packet contents into structured aircraft information.
- Trigger updates in the `AircraftDatabase` for the corresponding aircraft.

### Collaborators
- GroundStationReceiver
- Aircraft
- AircraftDatabase

---

## Class: DangerDetector

### Responsibilities
- Monitor current aircraft positions within the database.
- Identify potential conflicts or dangerous proximity between aircraft.
- Flag aircraft records that are in a dangerous state.

### Collaborators
- AircraftDatabase
- Aircraft
- GraphicsDisplay

---

## Class: Aircraft

### Responsibilities
- Store the unique aircraft identifier and type.
- Maintain current flight data (position, altitude, speed, heading).
- Update its internal state when new data is received.
- Provide aircraft information when requested by other components.

### Collaborators
- None (acts as a core data object used by other classes)

---

## Class: GraphicsDisplay

### Responsibilities
- Render a visual representation of the current airspace.
- Display aircraft positions based on database coordinates.
- Highlight aircraft that have been flagged as dangerous.

### Collaborators
- AircraftDatabase
- Aircraft
- DangerDetector

---

## Class: AircraftDatabase

### Responsibilities
- Store and maintain all active aircraft records.
- Update aircraft records when new data arrives.
- Provide aircraft data to other system components.
- Retrieve aircraft records using unique identifiers.

### Collaborators
- Aircraft
- PacketParser
- GraphicsDisplay
- DangerDetector
- ControllerInterface