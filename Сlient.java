package JoJo;

import java.util.*;

public class Сlient {
    public static void main(String[] args) {

        try {

            VideoBlog Java = new VideoBlog("Blogger");


            Java.addVideo(new Video("OOP", "java/oop.com", 15975, 864, 18));
            Java.getVideos().iterator().next().addComment(new Comment("Круто!", 8, 2));
            Java.getVideos().iterator().next().addComment(new Comment("Нормально", 23, 4));


            Java.addVideo(new Video("Safari", "java/safari.com", 12404, 6140, 1035));
            Java.getVideos().iterator().next().addComment(new Comment("Якось не цікаво", 90, 461));
            Java.getVideos().iterator().next().addComment(new Comment("Вау, які цікаві тваринки !", 1327, 56));


            Java.addVideo(new Video("Sorter", "java/sorter.com", 3304, 540, 9));
            Java.getVideos().iterator().next().addComment(new Comment("Коротко і ясно", 900, 9));
            Java.getVideos().iterator().next().addComment(new Comment("Ох! Треба вчитися", 137, 0));


            Java.print();
            System.out.println("\nЗагальна кількість перегладів: " + kilkist(Java));
            System.out.println("\nКоментар, який набрав більше лайків ніж відео, під яким він написаний:");
            likeComentMoreVideo(Java);
            System.out.println("\nВідео, яке набрало найбільшу кількість діслайків:");
            HashSet<String> dis = mostDislike(Java);
            for (String video : dis) {
                System.out.println(video);
            }
        } catch (InfoException e) {
            System.out.println(e.getMessage());


        } catch (NullPointerException e2) {
            System.out.println(e2.getMessage());
        } catch (IllegalArgumentException e1) {
            System.out.println(e1.getMessage());
        } finally {
            System.out.println("\nEnd of program.");
        }
    }

    public static int kilkist(VideoBlog vidos) {
        int sum = 0;
        Iterator<Video> iterator = vidos.getVideos().iterator();
        while (iterator.hasNext()) {
            Video i = iterator.next();
            sum += i.getViews();
        }
        return sum;
    }

    public static void likeComentMoreVideo(VideoBlog vidos) {
        int likeVideo;
        boolean more = true;
        for (Iterator i = vidos.getVideos().iterator(); i.hasNext(); ) {
            Object j = i.next();
            if (j instanceof Video) {
                Video video = (Video) j;
                likeVideo = video.getLike();
                for (Iterator k = video.getComment().iterator(); k.hasNext(); ) {
                    Object j1 = k.next();
                    if (j1 instanceof Comment) {
                        Comment comment = (Comment) j1;
                        if (comment.getLikeComment() > likeVideo) {
                            System.out.println("Коментар під відео: <<<" + comment.getText() + ">>>\nВідео: <<<" +
                                    video.getNameVideo() + ">>> В коментаря більше лайків ніж у відео");
                            more = false;
                        }
                    }
                }
            }
        }
        if (more) {
            System.out.println("Немає коментарів, у яких лайків більше ніж у відео");
        }
    }

    public static HashSet<String> mostDislike(VideoBlog vidos) {
        HashSet<String> list = new HashSet<>();
        int max = 0;
        for (Video video : vidos.getVideos()) {
            if (video.getDislike() > max) {
                list.clear();
                list.add(video.getNameVideo());
                max = video.getDislike();
            } else if (video.getDislike() == max) {
                list.add(video.getNameVideo());
            }
        }
        return list;

    }
}