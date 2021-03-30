

public class MusicAlbum implements Validated {
    @Required
    @MinLength(value = 1)
    @MaxLength(value = 5)
    private String id;

    @Required
    @MinLength(value = 5)
    @MaxLength(value = 100)
	private String name;

    @MinLength(value = 0)
    @MaxLength(value = 30)
	private String genre;

    private boolean compilation;

    @Required
    @Min(value = 0, inclusive = false)
	private int trackCount;

    public MusicAlbum() {
        this.id = "";
        this.name = "";
        this.genre = "";
        this.compilation = false;
        this.trackCount = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isCompilation() {
        return compilation;
    }

    public void setCompilation(boolean isCompilation) {
        this.compilation = isCompilation;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    @Override
    public String toString() {
        return "model.MusicAlbum{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", compilation=" + compilation +
                ", trackCount=" + trackCount +
                '}';
    }

    public boolean equals(Object obj) {
		if (obj instanceof MusicAlbum)
			return this.id.equalsIgnoreCase(((MusicAlbum)obj).id);

		return super.equals(obj);
	}
}
