package JoJo;

import java.util.*;

public class Video {
    private final String nameVideo;
    private final String url;
    private final int views;
    private final int like;
    private final int dislike;
    private final HashSet<Comment> comment = new HashSet<>();

    public Video(String nameVideo, String url, int views, int like, int dislike) throws InfoException {
        this.nameVideo = nameVideo;
        this.url = url;
        this.views = views;
        this.like = like;
        this.dislike = dislike;
        if (nameVideo.isEmpty()) {
            throw new InfoException("!!Error in name!!");
        }
        if (url.isEmpty()) {
            throw new InfoException("!!Error in url!!");
        }
        if (views < 0 | views < like | views < dislike | views < dislike + like) {
            throw new IllegalArgumentException("!!Error views!!");
        }
        if (like < 0) {
            throw new IllegalArgumentException("!!Error in likes!!");
        }
        if (dislike < 0) {
            throw new IllegalArgumentException("!!Error in dislikes!!");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Video video = (Video) o;

        if (views != video.views) return false;
        if (like != video.like) return false;
        if (dislike != video.dislike) return false;
        if (nameVideo != null ? !nameVideo.equals(video.nameVideo) : video.nameVideo != null) return false;
        return url != null ? url.equals(video.url) : video.url == null;
    }

    @Override
    public int hashCode() {
        int result = nameVideo != null ? nameVideo.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + views;
        result = 31 * result + like;
        result = 31 * result + dislike;
        return result;
    }

    public void addComment(Comment comment1) {
        comment.add(comment1);

    }

    public void print() {
        System.out.println("Назва відео: " + getNameVideo() + "; Силка на відео: " + getUrl() + "; Кількість переглялів: "
                + getViews() + "; Кількість лайків: " + getLike() + "; Кількість діслайків: " + getDislike());
        for (Comment comment : getComment()) {
            System.out.println(comment);
        }
    }

    public String getNameVideo() {
        return nameVideo;
    }

    public String getUrl() {
        return url;
    }

    public int getViews() {
        return views;
    }

    public int getLike() {
        return like;
    }

    public int getDislike() {
        return dislike;
    }

    public HashSet<Comment> getComment() {
        return comment;
    }
}
