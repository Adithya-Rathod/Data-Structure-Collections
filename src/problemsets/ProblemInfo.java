package problemsets;

import java.util.Arrays;

public record ProblemInfo(
        String name,
        Class<?> clazz,
        ProblemClass.Tag[] tags,
        ProblemClass.Topic topic,
        ProblemClass.Difficulty difficulty,
        String url,
        int leetCodeNumber
){
    public void print(){
        System.out.printf("[%s] %s (%s)%n", difficulty, name, topic);
        if(leetCodeNumber != -1) System.out.println("  LC #" + leetCodeNumber);
        if(!url.isEmpty())       System.out.println("  url: " + url);
        if(tags.length > 0)      System.out.println("  tags: " + Arrays.toString(tags));
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | topic=%s | tags=%s | lc=%s | url=%s",
                difficulty,
                name,
                topic,
                tags.length > 0 ? Arrays.toString(tags) : "none",
                leetCodeNumber == -1 ? "N/A" : String.valueOf(leetCodeNumber),
                url.isEmpty() ? "N/A" : url
        );
    }
}
