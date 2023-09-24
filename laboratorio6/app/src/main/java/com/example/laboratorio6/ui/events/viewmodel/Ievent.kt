package com.example.laboratorio6.ui.events.viewmodel

//Data class para facilidad de representacion de datos
data class Ievent(val eventID: String = "default event",
                  val title:String = "Title",
                  val details: String = "Supporting text",
                  val context: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed condimentum magna ultricies, placerat tellus sed, faucibus neque. Aenean porttitor eros.",
                  val date: String = "01/06/2016", val time: String = "08:00 p.m.",
                  val image: String = "https://img.freepik.com/free-vector/outdoor-music-festival-composition_1284-19595.jpg?w=2000")

//Evento default
val defEvent = Ievent()

//Listados de eventos a mostrar
val favEvents = listOf(defEvent,
    Ievent(image = "https://www.tasteofhome.com/wp-content/uploads/2021/10/GettyImages-1284067715-e1633375884844.jpg", eventID = "cups"),
    Ievent(image = "https://images.template.net/76446/Free-Music-Concert-Vector-1.jpg", eventID = "concert", title = "Concierto exterior"),
    Ievent(image = "https://img.freepik.com/premium-vector/people-holding-champagne-glasses_171919-963.jpg?w=2000", eventID = "cheers",
        context = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras lacinia purus velit. Sed quis tellus eget libero vestibulum ultrices euismod sed velit. Nunc posuere nulla orci, et elementum nulla aliquam sit amet. Curabitur sagittis placerat lobortis. Praesent pharetra, nulla eleifend sodales pharetra, tellus sem tristique quam, ut iaculis ante diam."))

val events = listOf(
    Ievent(image = "https://www.tasteofhome.com/wp-content/uploads/2021/10/GettyImages-1284067715-e1633375884844.jpg", eventID = "cups"),
    defEvent, defEvent,
    Ievent(image = "https://images.template.net/76446/Free-Music-Concert-Vector-1.jpg", eventID = "concert", title = "Concierto exterior"),
    Ievent(image = "https://img.freepik.com/premium-vector/people-holding-champagne-glasses_171919-963.jpg?w=2000", eventID = "cheers",
        context = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras lacinia purus velit. Sed quis tellus eget libero vestibulum ultrices euismod sed velit. Nunc posuere nulla orci, et elementum nulla aliquam sit amet. Curabitur sagittis placerat lobortis. Praesent pharetra, nulla eleifend sodales pharetra, tellus sem tristique quam, ut iaculis ante diam."),
    defEvent)