package com.sale.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sale.mapper.ScMapper;
import com.sale.entity.Sc;
import com.sale.service.ScService;
import org.springframework.stereotype.Service;

/**
 * (Sc)表服务实现类
 *
 * @author makejava
 * @since 2023-06-25 13:27:17
 */
@Service("scService")
public class ScServiceImpl extends ServiceImpl<ScMapper, Sc> implements ScService {

}



