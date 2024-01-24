package br.com.uepb.moviesm.models;

public class Series extends Title {
    // Atributos adicionais específicos da classe Series
    private int seasons;               // Número de temporadas
    private boolean active;            // Indica se a série está ativa
    private int episodesPerSeasons;    // Número de episódios por temporada
    private int minutesPerEpisode;      // Número de minutos por episódio

    // Construtor
    public Series(String name, int releaseYear) {
        super(name, releaseYear);
    }

    // Método getter para obter o número de temporadas
    public int getSeasons() {
        return seasons;
    }

    // Método setter para definir o número de temporadas
    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    // Método getter para verificar se a série está ativa
    public boolean getActive() {
        return active;
    }

    // Método setter para definir se a série está ativa
    public void setActive(boolean active) {
        this.active = active;
    }

    // Método getter para obter o número de episódios por temporada
    public int getEpisodesPerSeasons() {
        return episodesPerSeasons;
    }

    // Método setter para definir o número de episódios por temporada
    public void setEpisodesPerSeasons(int episodesPerSeasons) {
        this.episodesPerSeasons = episodesPerSeasons;
    }

    // Método getter para obter o número de minutos por episódio
    public int getMinutesPerEpisode() {
        return minutesPerEpisode;
    }

    // Método setter para definir o número de minutos por episódio
    public void setMinutesPerEpisode(int minutesPerEpisode) {
        this.minutesPerEpisode = minutesPerEpisode;
    }

    // Sobrescrita do método getDurationInMinutes para calcular a duração total da série em minutos
    @Override
    public int getDurationInMinutes() {
        return seasons * episodesPerSeasons * minutesPerEpisode;
    }

    // Sobrescrita do método toString para fornecer uma representação em string do objeto Series
    @Override
    public String toString() {
        return "Série: " + this.getName() + "(" + this.getReleaseYear() + ")";
    }
}
