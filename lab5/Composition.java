package lab5;

import java.util.Objects;

public abstract class Composition {
    protected String title;
    protected int duration; // тривалість в секундах
    protected String style;

    public Composition(String title, int duration, String style) {
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be positive.");
        }
        this.title = title;
        this.duration = duration;
        this.style = style;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Composition that = (Composition) obj;
        return duration == that.duration &&
            Objects.equals(title, that.title) &&
            Objects.equals(style, that.style);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, duration, style);
    }


    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getStyle() {
        return style;
    }

    @Override
    public String toString() {
        return title + " (" + duration + " sec, " + style + ")";
    }
}
