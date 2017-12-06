
package anindya.redditapi.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChildData {

    @SerializedName("domain")
    @Expose
    public String domain;
    @SerializedName("approved_at_utc")
    @Expose
    public Object approvedAtUtc;
    @SerializedName("banned_by")
    @Expose
    public Object bannedBy;
//    @SerializedName("media_embed")
//    @Expose
//    public MediaEmbed mediaEmbed;
    @SerializedName("thumbnail_width")
    @Expose
    public int thumbnailWidth;
    @SerializedName("subreddit")
    @Expose
    public String subreddit;
    @SerializedName("selftext_html")
    @Expose
    public Object selftextHtml;
    @SerializedName("selftext")
    @Expose
    public String selftext;
    @SerializedName("likes")
    @Expose
    public Object likes;
    @SerializedName("suggested_sort")
    @Expose
    public Object suggestedSort;
    @SerializedName("user_reports")
    @Expose
    public List<Object> userReports = null;
    @SerializedName("secure_media")
    @Expose
    public Object secureMedia;
    @SerializedName("is_reddit_media_domain")
    @Expose
    public boolean isRedditMediaDomain;
    @SerializedName("link_flair_text")
    @Expose
    public Object linkFlairText;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("banned_at_utc")
    @Expose
    public Object bannedAtUtc;
    @SerializedName("view_count")
    @Expose
    public Object viewCount;
    @SerializedName("archived")
    @Expose
    public boolean archived;
    @SerializedName("clicked")
    @Expose
    public boolean clicked;
    @SerializedName("report_reasons")
    @Expose
    public Object reportReasons;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("num_crossposts")
    @Expose
    public int numCrossposts;
    @SerializedName("saved")
    @Expose
    public boolean saved;
    @SerializedName("mod_reports")
    @Expose
    public List<Object> modReports = null;
    @SerializedName("can_mod_post")
    @Expose
    public boolean canModPost;
    @SerializedName("is_crosspostable")
    @Expose
    public boolean isCrosspostable;
    @SerializedName("pinned")
    @Expose
    public boolean pinned;
    @SerializedName("score")
    @Expose
    public int score;
    @SerializedName("approved_by")
    @Expose
    public Object approvedBy;
    @SerializedName("over_18")
    @Expose
    public boolean over18;
    @SerializedName("hidden")
    @Expose
    public boolean hidden;
    @SerializedName("thumbnail")
    @Expose
    public String thumbnail;
    @SerializedName("subreddit_id")
    @Expose
    public String subredditId;
    @SerializedName("edited")
    @Expose
    public boolean edited;
    @SerializedName("link_flair_css_class")
    @Expose
    public Object linkFlairCssClass;
    @SerializedName("author_flair_css_class")
    @Expose
    public Object authorFlairCssClass;
    @SerializedName("contest_mode")
    @Expose
    public boolean contestMode;
    @SerializedName("gilded")
    @Expose
    public int gilded;
    @SerializedName("downs")
    @Expose
    public int downs;
    @SerializedName("brand_safe")
    @Expose
    public boolean brandSafe;
//    @SerializedName("secure_media_embed")
//    @Expose
//    public SecureMediaEmbed secureMediaEmbed;
    @SerializedName("removal_reason")
    @Expose
    public Object removalReason;
    @SerializedName("author_flair_text")
    @Expose
    public Object authorFlairText;
    @SerializedName("stickied")
    @Expose
    public boolean stickied;
    @SerializedName("can_gild")
    @Expose
    public boolean canGild;
    @SerializedName("thumbnail_height")
    @Expose
    public int thumbnailHeight;
    @SerializedName("parent_whitelist_status")
    @Expose
    public String parentWhitelistStatus;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("spoiler")
    @Expose
    public boolean spoiler;
    @SerializedName("permalink")
    @Expose
    public String permalink;
    @SerializedName("subreddit_type")
    @Expose
    public String subredditType;
    @SerializedName("locked")
    @Expose
    public boolean locked;
    @SerializedName("hide_score")
    @Expose
    public boolean hideScore;
    @SerializedName("created")
    @Expose
    public double created;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("whitelist_status")
    @Expose
    public String whitelistStatus;
    @SerializedName("quarantine")
    @Expose
    public boolean quarantine;
    @SerializedName("author")
    @Expose
    public String author;
    @SerializedName("created_utc")
    @Expose
    public double createdUtc;
    @SerializedName("subreddit_name_prefixed")
    @Expose
    public String subredditNamePrefixed;
    @SerializedName("ups")
    @Expose
    public int ups;
    @SerializedName("media")
    @Expose
    public Object media;
    @SerializedName("num_comments")
    @Expose
    public int numComments;
    @SerializedName("is_self")
    @Expose
    public boolean isSelf;
    @SerializedName("visited")
    @Expose
    public boolean visited;
    @SerializedName("num_reports")
    @Expose
    public Object numReports;
    @SerializedName("is_video")
    @Expose
    public boolean isVideo;
    @SerializedName("distinguished")
    @Expose
    public Object distinguished;
    @SerializedName("preview")
    @Expose
    public Preview preview;
    @SerializedName("post_hint")
    @Expose
    public String postHint;

}
