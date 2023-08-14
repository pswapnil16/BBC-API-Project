package com.bbc.api.cucumbertests.definitions;

import com.bbc.api.cucumbertests.entity.DataItem;
import com.bbc.api.cucumbertests.entity.RMSResponse;
import com.bbc.api.executor.RequestExecutor;
import io.cucumber.java.en.And;

import static org.testng.Assert.*;

public class RmsStepDefinitions extends RequestExecutor {

    RMSResponse responseData = restResponse.body().as(RMSResponse.class);

    @And("the id field is never null or empty for all the items in array")
    public void theIdFieldIsNeverNullOrEmptyForAllTheItemsInArray() {
        assertTrue(responseData.getData().stream().map(DataItem::getId).allMatch(RmsStepDefinitions::isValid),
                "Id's should be not null or Empty");
    }

    @And("the segment_type field is always {string}")
    public void theSegment_typeFieldIsAlways(String segmentType) {
        assertTrue(responseData.getData().stream().map(DataItem::getSegmentType)
                        .allMatch(seg -> seg.equalsIgnoreCase(segmentType)),
                "Segment type should be always music");
    }

    @And("the primary field in title_list is never null or empty for any track")
    public void thePrimaryFieldInTitle_listIsNeverNullOrEmptyForAnyTrack() {
        assertTrue(responseData.getData().stream().map(DataItem::getTitleList)
                        .allMatch(titleList -> isValid(titleList.getPrimary())),
                "Primary field in title_list should be never null or empty for any track");
    }

    @And("only one track in the list has now_playing field in offset as true")
    public void onlyOneTrackInTheListHasNow_playingFieldInOffsetAsTrue() {

        assertEquals(responseData.getData().stream().map(DataItem::getOffset)
                        .filter(offset -> offset.isNowPlaying()).count(), 1,
                "Only one track can be true at a given time");
    }

    @And("response headers should have date value")
    public void responseHeadersShouldHaveDateValue() {
        assertNotNull(restResponse.header("Date"), "Date cannot be null");
    }

    private static boolean isValid(String idValue) {
        return idValue != null && !idValue.isEmpty();
    }
}
