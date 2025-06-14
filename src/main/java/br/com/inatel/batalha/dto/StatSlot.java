package br.com.inatel.batalha.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StatSlot {
    private int base_stat;
    private int effort;
    private InnerStat stat;

    @Getter
    @Setter
    public static class InnerStat {
        private String name;
    }
}