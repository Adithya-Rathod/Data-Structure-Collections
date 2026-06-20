package problemsets;

import java.io.File;
import java.net.URL;
import java.util.*;

public final class ProblemRepository {

    private ProblemRepository(){}

    private static final List<ProblemInfo> ALL = new ArrayList<>();

    // init step.
    static {
        scan("problemsets");
    }

    private static void scan(String packageName) {
        String path = packageName.replace(".", "/");
        try {
            // use classLoader to get from the root of the application and normal class within this package.
            URL res = ProblemRepository.class.getClassLoader().getResource(path);
            if (res == null) return;
            walkDirectory(new File(res.toURI()), packageName);
        } catch (Exception e) {

        }
    }

    private static void walkDirectory(File dir, String pkgName) throws Exception {
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.isDirectory()) {
                walkDirectory(file, pkgName + "." + file.getName());
            } else if (file.getName().endsWith(".class")) {
                String className = pkgName + "." + file.getName().replace(".class", "");
                Class<?> clazz = Class.forName(className);
                ProblemClass ann = clazz.getAnnotation(ProblemClass.class);
                if(ann != null){
                    ALL.add(new ProblemInfo(clazz.getSimpleName(), clazz, ann.tags(), ann.topic(), ann.difficulty(), ann.url(), ann.leetCodeNumber()));
                }
            }
        }
    }


    // query on top
    public static void getAll(){
         ALL.forEach(p -> System.out.println(p + "\n"));
    }

    public static void byDifficulty(ProblemClass.Difficulty d){
         ALL.stream()
                 .filter(p -> p.difficulty() == d)
                 .forEach(p -> System.out.println(p + "\n"));
    }

    public static void byTopic(ProblemClass.Topic t){
         ALL.stream()
                 .filter(p -> p.topic() == t)
                 .forEach(p -> System.out.println(p + "\n"));
    }

    public static void byTag(ProblemClass.Tag tag){
         ALL.stream()
                 .filter(p -> Arrays.asList(p.tags()).contains(tag))
                 .forEach(p -> System.out.println(p + "\n"));
    }

    public static void byTags(ProblemClass.Tag[] tags){
        List<ProblemClass.Tag> tagList = Arrays.asList(tags);
        ALL.stream()
                .filter(p -> Arrays.stream(p.tags()).anyMatch(tagList::contains))
                .forEach(p -> System.out.println(p + "\n"));
    }

    public static void byDifficultyAndTopic(ProblemClass.Difficulty d, ProblemClass.Topic t){
        ALL.stream()
                .filter(p -> p.difficulty() == d && p.topic() == t)
                .forEach(p -> System.out.println(p + "\n"));
    }

    public static void byDifficultyAndTag(ProblemClass.Difficulty d, ProblemClass.Tag[] tags){
        List<ProblemClass.Tag> tagList = Arrays.asList(tags);
        ALL.stream()
                .filter(p -> p.difficulty() == d)
                .filter(p -> Arrays.stream(p.tags()).anyMatch(tagList::contains))
                .forEach(p -> System.out.println(p + "\n"));
    }
    public static void byLeetCodeNumber(int l){
        Optional<ProblemInfo> problems =  ALL.stream()
                .filter(p -> p.leetCodeNumber() == l)
                .findFirst();
        problems.ifPresent(System.out::println);
    }


}
