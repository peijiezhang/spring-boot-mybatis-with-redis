package com.wooyoo.learning.dao;

import com.wooyoo.learning.model.dto.FileDto;

public interface FileTreeDao {

    public Object getFileTreeList(FileDto fileDto);
}
