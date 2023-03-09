package com.lostlife.BookMyShow.Converters;

import com.lostlife.BookMyShow.models.Show;
import com.lostlife.BookMyShow.requestDTOs.ShowEntryDTO;

public class ShowConverters {
    public static Show convertEntryDtoToEntity(ShowEntryDTO showEntryDTO){
        Show show=Show.builder().showDate(showEntryDTO.getLocalDate())
                .showTime(showEntryDTO.getLocalTime())
                .showType(showEntryDTO.getShowType()).build();

        return show;
    }
}
