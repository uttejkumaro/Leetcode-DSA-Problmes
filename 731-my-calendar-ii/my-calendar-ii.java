class MyCalendarTwo {
    ArrayList<Event> overlappingEvents;
    ArrayList<Event> events;

    public MyCalendarTwo() {
        overlappingEvents = new ArrayList<>();
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(Event ev : overlappingEvents){
            if(isOverlapping(ev, start, end)){
                return false;
            }
        }

        for(Event ev : events){
            if(isOverlapping(ev, start, end)){
                overlappingEvents.add(overlapped(ev, start, end));
            }
        }
        events.add(new Event(start, end));
        return true;
    }

    boolean isOverlapping(Event ev, int s, int e){
        return Math.max(ev.start, s) < Math.min(ev.end, e);
    }

    Event overlapped(Event ev, int s, int e){
        return new Event(Math.max(ev.start, s), Math.min(ev.end, e));
    }
}

class Event {
    int start, end;
    public Event(int s, int e){
        this. start = s;
        this.end = e;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */