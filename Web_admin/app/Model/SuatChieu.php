<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
class SuatChieu extends Model
{
    use SoftDeletes;

    protected $dates = ['deleted_at'];

    protected $fillable = [
    	'GioChieu',
		'lichchieu_id'
        'phim_id'
    ];

    protected function lichchieu()
	{
		$this->belongsTo('Model\LichChieu','lichchieu_id');
	}
    protected function phim()
    {
        $this->belongsTo('Model\Phim','phim_id');
    }
}
