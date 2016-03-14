//////////////////////////////////////////////////////////////////////////
//降雨等值线相关对象类
//@author fmm 2015-07-01
//////////////////////////////////////////////////////////////////////////

/*
*	降雨等值线命名空间
*@author fmm 2015-07-01
*/
ContourLine = {}

/*
*	离散数据网格化参数类
*param {string} SfClsURL 点简单要素类URL
*param {string} FieldName Z值所在的字段名称
*param {int} XCellNum 生成的影像X方向网格数。只输出X方向网格数，计算时Y方向网格密度会自动与X方向保持一致,默认值为200
*param {Rect} Bound 生成的栅格数据集逻辑范围，如果为NULL则使用点简单要素类的逻辑范围
*@author fmm 2015-07-01
*/
//ContourLine.MeshingParam = function () {
ContourLine.MeshingParam = function (SfClsURL, FieldName, XCellNum, Bound) {
    this.SfClsURL = SfClsURL;
    this.FieldName = FieldName;
    var XCellNum = arguments[2] ? arguments[2] : 200;
    this.XCellNum = XCellNum;
    this.Bound = Bound;
}


/*
*	平面等值线追踪所用到的注记参数类
*param {bool} IsClipLine 注记是否剪断线(true/false 剪断/不剪断),默认值为true
*param {bool} isXYScaleOut 是否输出轴向标尺,默认值为false
*param {int} NoteDirection 注记方向(1/2/3:斜坡上方/斜坡下方/图幅上方),默认值为1
*param {double} LineWidth 注记等值线线宽,默认值为0.05
*param {float} MaxAngle 注记的最大倾角,默认值为90.0
*param {float} MinDist 注记间最小允许距离,默认值为10.0
*param {bool} IsAbs 数值是否取绝对值,默认值为false
*param {bool} IsComma 数值是否采用千位分隔符,默认值为false
*param {short} DigitNum 注记数值的小数位数,默认值为0
*param {int} FormatNo 数据格式 （0/1/2: 定点/科学/通常）,默认值为0
*param {int} LogFlag 取对数标志（0/1/2: 未取对数/10为底/自然对数）,默认值为0
*param {string} Prefix 注记前缀,默认值为""
*param {string} Suffix 注记后缀,默认值为""
*param {int} ColorNo 注记颜色号,默认值为0
*param {float} FixSize 注记尺寸,默认值为0.01
*param {short} FontNo 注记字体号,默认值为0
*@author fmm 2015-07-01
*/
ContourLine.ContourNoteParam = function (settings) {
    var defaultSetting = {
        IsClipLine: true,
        isXYScaleOut: false,
        NoteDirection: 1,
        LineWidth: 0.05,
        MaxAngle: 90.0,
        MinDist: 10.0,
        IsAbs: false,
        IsComma: false,
        DigitNum: 0,
        FormatNo: 0,
        LogFlag: 0,
        Prefix: "",
        Suffix: "",
        ColorNo: 0,
        FixSize: 0.01,
        FontNo: 0
    };
    $.extend(defaultSetting, settings);
    this.IsClipLine = defaultSetting.IsClipLine;
    this.isXYScaleOut = defaultSetting.isXYScaleOut;
    this.NoteDirection = defaultSetting.NoteDirection;
    this.LineWidth = defaultSetting.LineWidth;
    this.MaxAngle = defaultSetting.MaxAngle;
    this.MinDist = defaultSetting.MinDist;
    this.IsAbs = defaultSetting.IsAbs;
    this.IsComma = defaultSetting.IsComma;
    this.DigitNum = defaultSetting.DigitNum;
    this.FormatNo = defaultSetting.FormatNo;
    this.LogFlag = defaultSetting.LogFlag;
    this.Prefix = defaultSetting.Prefix;
    this.Suffix = defaultSetting.Suffix;
    this.ColorNo = defaultSetting.ColorNo;
    this.FixSize = defaultSetting.FixSize;
    this.FontNo = defaultSetting.FontNo;
}

/*
*	等值线层参数类，用来描述每一层的信息
*param {double} ZValue 等值线层值，不能为NULL,默认值为1.0
*param {CLineInfo} LineInfo 等值线参数，为空则取默认值
*param {CRegionInfo} RegInfo 生成区参数，为空则取默认值
*param {bool} IsOutputNote 该层是否绘制注记,默认值为false
*@author fmm 2015-07-01
*/
ContourLine.ContourZValue=function (ZValue, LineInfo, RegInfo, IsOutputNote) {
    var ZValue = arguments[0] ? arguments[0] : 1;
    var IsOutputNote = arguments[3] ? arguments[3] : false;
    this.ZValue = ZValue;
    this.LineInfo = LineInfo;
    this.RegInfo = RegInfo;
    this.IsOutputNote = IsOutputNote;
}

/*
*	描述线参数
*param {double} LinWidth 线宽度,默认值为1
*param {int} Color 线颜色,默认值为1
*param {int} LinStyleID 线型号,默认值为1
*param {int} LinStyleID2 辅助线型号,默认值为0
*param {double} Xscale X比例系数,默认值为1.0
*param {double} Yscale Y比例系数,默认值为1.0
*@author fmm 2015-07-01
*/
ContourLine.CLineInfo = function (settings) {
    var defaultSetting = {
        LinWidth: 1,
        Color: 1,
        LinStyleID: 1,
        LinStyleID2: 0,
        Xscale: 1.0,
        Yscale: 1.0
    };
    $.extend(defaultSetting, settings);
    this.LinWidth = defaultSetting.LinWidth;
    this.Color = defaultSetting.Color;
    this.LinStyleID = defaultSetting.LinStyleID;
    this.LinStyleID2 = defaultSetting.LinStyleID2;
    this.Xscale = defaultSetting.Xscale;
    this.Yscale = defaultSetting.Yscale;
}

/*
*	描述区参数
*param {int} PatID 填充图案编号,仅当填充模式为0(常规填充)才有意义。取0则无图案填充,默认值为0
*param {int} FillMode 填充模式,0:常规填充、1:线性渐变填充、2:矩形渐变填充、3:圆形渐变填充,默认值为0
*param {int} FillColor 填充色或起始色,当填充模式为0(常规填充)时,表示区填充色;当填充模式为1(线性渐变填充)或2(矩形渐变填充)或3(圆形渐变填充)时,表示起始色,默认值为1
*param {int} EndColor 终止色,仅当填充模式为1(线性渐变填充)或2(矩形渐变填充)或3(圆形渐变填充)时才有意义,默认值为1
*param {double} PatHeight 图案高,仅当填充模式为0(常规填充)才有意义,默认值为1.0
*param {double} PatWidth 图案宽,仅当填充模式为0(常规填充)才有意义,默认值为1.0
*param {double} PatAngle 图案角度或渐变角度,当填充模式为0(常规填充)时,表示图案角度;当填充模式为1(线性渐变填充)或2(矩形渐变填充)时,表示渐变角度;当填充模式为3(圆形渐变填充)时,此属性无意义,默认值为1.0
*param {int} PatColor 图案颜色,仅当填充模式为0(常规填充)才有意义,默认值为1
*param {double} OutPenWidth 图案笔宽,仅当填充模式为0(常规填充)才有意义,默认值为1.0
*param {short} OverMethod 覆盖方式(无意义),默认值为0
*@author fmm 2015-07-01
*/
ContourLine.CRegionInfo = function (settings) {
    var defaultSetting = {
        PatID: 0,
        FillMode: 0,
        FillColor: 1,
        EndColor: 1,
        PatHeight: 1.0,
        PatWidth: 1.0,
        PatAngle: 1.0,
        PatColor: 1.0,
        OutPenWidth: 1.0,
        OverMethod: 0
    };
    $.extend(defaultSetting, settings);
    this.PatID = defaultSetting.PatID;
    this.FillMode = defaultSetting.FillMode;
    this.FillColor = defaultSetting.FillColor;
    this.EndColor = defaultSetting.EndColor;
    this.PatHeight = defaultSetting.PatHeight;
    this.PatWidth = defaultSetting.PatWidth;
    this.PatAngle = defaultSetting.PatAngle;
    this.PatColor = defaultSetting.PatColor;
    this.OutPenWidth = defaultSetting.OutPenWidth;
    this.OverMethod = defaultSetting.OverMethod;
}

/*
*	示坡线参数类
*param {float} XScale X系数,默认值为2.0
*param {float} YScale Y系数,默认值为10.0
*param {short} LineType 线型,默认值为0
*param {short} SubLineType 辅助线型,默认值为0
*@author fmm 2015-07-01
*/
ContourLine.SlopLineParam = function (settings) {
   var defaultSetting = {
        XScale: 2.0,
        YScale: 10.0,
        LineType: 0,
        SubLineType: 0
    };
    $.extend(defaultSetting, settings);
    this.XScale = defaultSetting.XScale;
    this.YScale = defaultSetting.YScale;
    this.LineType = defaultSetting.LineType;
    this.SubLineType = defaultSetting.SubLineType;
}

/*
*	平面等值线追踪参数类
*param {bool} IsSmoothLine 是否进行光滑线处理；如果为true则配合SmoothGrade使用,默认值为false
*param {int} SmoothGrade 线光滑程度， 0/1/2分别代表“低/中/高”，仅在IsSmoothLine为true时生效,默认值为1
*param {bool} IsMakeReg 是否生成区,默认值为false
*param {bool} IsMakeNote 是否生成注记,默认值为false
*param {bool} IsMakeSLin 是否输出示坡线,默认值为false
*param {int} MapWay 生成的地图范围的设置方法。0/1/2/3分表表示“自动检测设置/原始数据范围/数据投影变换/用户自定义”,默认值为1
*param {double} FrameWidth 制图宽度，仅在MapWay=3的情况下有效,默认值为1.0
*param {double} FrameHeight 制图高度，仅在MapWay=3的情况下有效,默认值为1.0
*param {bool} IsDrawColorScl 是否绘制色阶。如果绘制，则必须同时指定生成线、区、注记层，任何一个图层都不能忽略生成，才可见色阶输出效果,默认值为false
*param {bool} IsSaveEdge 线图层是否保存边界,默认值为false
*param {ContourNoteParam} NoteParam 注记生成参数，如果NULL则取默认值。只有在IsMakeNote为true时该参数才能发挥作用
*param {SlopLineParam} SlopLineParam 示坡线参数，如果为NULL则取默认值。只有在IsMakeSLin为true时该参数参能发挥作用
*param {ContourZValue[]} ZValues 等值线层参数，不能为NULL
*       如果ZValues的最大层值小于影像最大像元值，则生成的区值区间是ZValues的次大值到像元最大值；如果要绘制ZVlaues最大值到像元最大值区间，需要为ZValues增加一个大于最大像元值的成员
*@author fmm 2015-07-01
*/
ContourLine.ContourParam = function (settings, NoteParam, slopLineParam, ZValues) {
    var defaultSetting = {
        IsSmoothLine: false,
        SmoothGrade: 1,
        IsMakeReg: false,
        IsMakeNote: false,
        IsMakeSLin: false,
        MapWay: 1,
        FrameWidth: 1.0,
        FrameHeight: 1.0,
        IsDrawColorScl: false,
        IsSaveEdge: false
    };
    $.extend(defaultSetting, settings);
    this.IsSmoothLine = defaultSetting.IsSmoothLine;
    this.SmoothGrade = defaultSetting.SmoothGrade;
    this.IsMakeReg = defaultSetting.IsMakeReg;
    this.IsMakeNote = defaultSetting.IsMakeNote;
    this.IsMakeSLin = defaultSetting.IsMakeSLin;
    this.MapWay = defaultSetting.MapWay;
    this.FrameWidth = defaultSetting.FrameWidth;
    this.FrameHeight = defaultSetting.FrameHeight;
    this.IsDrawColorScl = defaultSetting.IsDrawColorScl;
    this.IsSaveEdge = defaultSetting.IsSaveEdge;
    this.NoteParam = NoteParam;
    this.SlopLineParam = slopLineParam;
    this.ZValues = ZValues;
};

/*
*	定义返回到前台参数的类
*@author fmm 2015-07-01
*/
ContourLine.ResultContour = function(ip, port, wp, wl, wt) {
    this.ip = ip;
    this.port = port;
    this.wp = wp;
    this.wl = wl;
    this.wt = wt;
};

/*
*	定义返回到前台的类，以便转为json对象
*@author fmm 2015-07-01
*/
ContourLine.ResultParam = function(isSuccess, resultContour) {
    this.isSuccess = isSuccess;
    this.resultContour = resultContour;
};