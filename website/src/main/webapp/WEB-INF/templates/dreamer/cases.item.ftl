<div class="hide">
    <#list descriptionVo.items as item>
        <a href="${(item.imageUrl)!}" title="${(item.content)!}" class="photo-link" rel="prettyPhoto[pic-case-${(descriptionVo.info.id)!}]">
            <img src="${(item.imageThumbUrl)!}" alt="${(descriptionVo.info.head)!}" class="wide-image"/>
        </a>
    </#list>
</div>