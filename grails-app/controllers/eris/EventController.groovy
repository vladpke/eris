package eris

class EventController {
	
	static scaffold = true
	
    def index() { 
		
		if (!params.id) {
			[eventInstanceList: Event.list()]
		}else {
			
			def results = Event.findAllByUser(User.get(params.id))
			
			[eventInstanceList: results]
		}
	}
	
	def report() {
		
		def u = User.get(params.id)

		def appls = Appliance.findAllByUser(u)
		
		def eventList = []
		
		for (app in appls) {
			eventList.add(Event.findAllByAppliance(app))	
		}
		
		[userEventList: eventList, theuser: u]
	}
}
