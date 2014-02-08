package org.ngnono.gechu.core.common.rss;

import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Description;
import com.sun.syndication.feed.rss.Item;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ngnono on 14-2-8.
 */
public class RssFeedView extends AbstractRssFeedView {

    @Override
    protected void buildFeedMetadata(Map<String, Object> model, Channel feed,
                                     HttpServletRequest request) {
        String feedTitle = (String) model.get("feedTitle");

        String feedDesc = (String) model.get("feedDesc");

        String feedLink = (String) model.get("feedLink");

        feed.setTitle(feedTitle);
        feed.setDescription(feedDesc);
        feed.setLink(feedLink);

    }


    /**
     * Subclasses must implement this method to build feed items, given the model.
     * <p>Note that the passed-in HTTP response is just supposed to be used for
     * setting cookies or other HTTP headers. The built feed itself will automatically
     * get written to the response after this method returns.
     *
     * @param model    the model Map
     * @param request  in case we need locale etc. Shouldn't look at attributes.
     * @param response in case we need to set cookies. Shouldn't write to it.
     * @return the feed items to be added to the feed
     * @throws Exception any exception that occured during document building
     * @see com.sun.syndication.feed.rss.Item
     */
    @Override
    protected List<Item> buildFeedItems(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        @SuppressWarnings("unchecked")
        List<RssItem> rssItems = (List<RssItem>) model.get("rssItemList");
        List<Item> feedItems = new ArrayList<Item>();
        for (RssItem rssItem : rssItems) {

            Item feedItem = new Item();
            feedItem.setTitle(rssItem.getTitle());
            feedItem.setAuthor(rssItem.getAuthor());
            feedItem.setPubDate(rssItem.getDatePublished());
            Description desc = new Description();
            desc.setValue(rssItem.getDescription());
            feedItem.setDescription(desc);
            feedItem.setLink(rssItem.getLink());
            feedItems.add(feedItem);
        }
        return feedItems;
    }
}
