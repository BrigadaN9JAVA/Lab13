package JoJo;

public class Comment {
    private String text;
    private int likeComment;
    private int dislikeComment;

    public Comment(String text, int likeComment, int dislikeComment) {
        this.text = text;
        this.likeComment = likeComment;
        this.dislikeComment = dislikeComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (likeComment != comment.likeComment) return false;
        if (dislikeComment != comment.dislikeComment) return false;
        return text != null ? text.equals(comment.text) : comment.text == null;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + likeComment;
        result = 31 * result + dislikeComment;
        return result;
    }

    @Override
    public String toString() {
        return " ***Comment: *** " + getText() + "; Кількість лайків: " + getLikeComment()
                + "; Кількість діслайків: " + getDislikeComment();
    }


    public String getText() {
        return text;
    }

    public int getLikeComment() {
        return likeComment;
    }

    public int getDislikeComment() {
        return dislikeComment;
    }
}

