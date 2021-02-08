package JoJo;
import java.util.*;


public class VideoBlog {
    private String bloger;
    private HashSet<Video> videos = new HashSet<>();

    public VideoBlog(String bloger){
        this.bloger = bloger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoBlog videoBlog = (VideoBlog) o;

        return bloger != null ? bloger.equals(videoBlog.bloger) : videoBlog.bloger == null;
    }

    @Override
    public int hashCode() {
        return bloger != null ? bloger.hashCode() : 0;
    }

    public void print(){
        System.out.println("<<<<<VideoBloger:>>>>>  " + getBloger());
        for(Video video : getVideos()){
            video.print();
        }
    }

    public void addVideo(Video video){
            getVideos().add(video);
    }

    public String getBloger() {
        if (bloger.isEmpty()){
            throw new NullPointerException("!!Error in blogger's name!!");
        }
        return bloger;
    }

    public HashSet<Video> getVideos() {
        return videos;
    }
}

